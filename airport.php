<?php
include_once("../../../translatetoPHP/translationutils/jsarray.php");
include_once("atc.php");
include_once("A320.php");
class Airport{
  function __construct($taxiwayint, $gatecharsint, $gateintforchars){
    $this->time     = json_decode('{"yyyy":2017,"mo":0,"dd":0,"hh":0,"mi":0,"ss":0}');
    $this->GND      = new GND;
    $chars          = new jsarray("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
    $this->taxiways = array();
    $this->gates    = array();
    $h              = 25;
    $this->entities = array($this->GND,new A320(12,13));
    for ($i = 0; $i < $gatecharsint; $i++) {
      $a = $chars($i);
      for ($o = 0; $o < $gateintforchars - 1; $o++) {
        $this->gates[$a . $o] = '{"planeoccupying":NULL}';
      }
    }
    for ($i = 0; $i < $taxiwayint; $i++) {
      $a                                = rand(0, $h);
      $l                                = rand(0, 1500);
      $this->taxiways[$chars($a) . ":"] = '{"length":' . $l . ',"occupyingvehicles":[]}';
      $chars->pop($a, NULL);
      $h--;
    }
  }
  function timestep(){
    if ($this->time->{"ss"} != 60) {
      $this->time->{"ss"}++;
    } else {
      $this->time->{"ss"} = 0;
      if ($this->time->{"mi"} != 60) {
        $this->time->{"mi"}++;
      } else {
        $this->time->{"mi"} = 0;
        if ($this->time->{"hh"} != 24) {
          $this->time->{"hh"}++;
        } else {
          $this->time->{"hh"} = 0;
          if ($this->time->{"dd"} != 30) {
            $this->time->{"dd"}++;
          } else {
            $this->time->{"dd"} = 0;
            if ($this->time->{"mo"} != 12) {
              $this->time->{"mo"}++;
            } else {
              $this->time->{"mo"} = 0;
              $this->time->{"yyyy"}++;
            }
          }
        }
      }
    }
    foreach($this->entities as $entity){
      $entity->update();
    }
  }
}
$a = new Airport(10, 4, 5);
$a->timestep();
?>
