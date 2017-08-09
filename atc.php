<?php
/* format for tower requests in json:
 * Operations:
 *-- pushbackapprove
 *-- taxirequest
 *-- takeoff
 *{
 *  "plane": "N09456",
 *  "request":{
 *    "operation": "pushbackleft"
 *  }
 *}
 *{
 *  "plane": "N09456",
 *  "request":{
 *    "operation": "taxirequest",
 *    "route":["F","D","hs21L"]
 *  }
 *}
 *{
 *  "plane": "N09456",
 *  "request":{
 *    "operation": "takeoff",
 *    "runway":"12L"
 *  }
 *}
 * format for tower responses
 *{
 *  "plane": "N09456"
 *  "response":{
 *    "operation":"pushback",
 *    "verdict":true
 *  }
 *}
 *{
 *  "plane":"N09456",
 *  "response":{
 *    "operation":"takeoff",
 *    "runway":"21L",
 *    "verdict":"approved"
 *  }
 *}
 *{
 *	"plane": "N09456",
 *	"response":{
 *		"operation": "taxirequest",
 *		"route":["F","D","hs21L"],
 *		"verdict":true
 *	}
 *}*/
include_once("../utils.php");
class GND{
	function __construct(){
		$this->queue = array();
		$this->responses = array();
	}
	function sendRequest($req){
		$req = utf8_encode($req);
		array_push($this->queue,$req);
	}
	function respond($plane){
		for($i = 0; $i<count($this->queue);$i++){
			if(strpos(indx($i,$this->queue),$plane)!==false){
				$req = json_decode(indx($i,$this->queue));
			} else {
				return NULL;
			}
		}
		if(strpos(json_encode($req),"pushback")!==false){
			if(rand(0,1)){
				array_push($this->responses,'{"plane":"'.$plane.'","request":{"operation":"'.$req->{"request"}->{"operation"}.'","verdict":true}}');
			} else {
				array_push($this->responses,'{"plane":"'.$plane.'","request":{"operation":"'.$req->{"request"}->{"operation"}.'","verdict":false}}');
			}
		} else if(strpos(json_encode($req),"taxirequest")!==false){
			if(rand(0,1)){
				array_push($this->responses,'{"plane":"'.$plane.'","request":{"operation":"'.$req->{"request"}->{"operation"}.'","verdict":true}}');
			} else {
				array_push($this->responses,'{"plane":"'.$plane.'","request":{"operation":"'.$req->{"request"}->{"operation"}.'","verdict":false,"taxipath":['.bin2hex(random_bytes(5)).']}}');
			}
		} else {
			if(rand(0,1)){
				array_push($this->responses,'{"plane":"'.$plane.'","request":{"operation":"'.$req->{"request"}->{"operation"}.'","verdict":true}}');
			} else {
				array_push($this->responses,'{"plane":"'.$plane.'","request":{"operation":"'.$req->{"request"}->{"operation"}.'","verdict":false}}');
			}
		}
		$this->queue = array_splice($this->queue,0,0);
	}
	function update(){
		if(count($this->queue) !== 0){
			respond(indx(0,$this->queue));
		} else {
			echo "hi\n";
		}
	}
}
?>
