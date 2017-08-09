<?php
class Plane{
  function calcFuel($lat, $long){
    $distnm = distance($this->latitude, $this->longitude, $lat, $long);
    return (1 / $this->nmpg) * $distnm;
  }
  function flyTo($point){
    $dist = 60*sqrt(pow(abs($point["latitude"] - $this->latitude),2) + pow(abs($point["longitude"],2)));
    if ($dist > $this->range - 5 | $dist === 0) {
      return false;
    } else {
      $this->currentFuel-= calcFuel($point["latitude"], $point["longitude"]);
      $this->latitude = $point["latitude"];
      $this->longitude = $point["longitude"];
      $this->currentTaxiway = NULL;
      return true;
    }
  }
  function fuelup($amnt){
    if ($amnt + $currentFuel > $maxFuel) {
      $this->currentFuel = $maxFuel;
    }
    else {
      $this->currentFuel+= $amnt;
    }
  }
  function request($operation, $tower){
    $tower->sendRequest('{"plane":"'.$this->id.'","request":{"operation":"'.$operation.'"}}');
  }
  function listen($atc){if(!$atc->responses){}}
  function respond($response){
    $response = json_decode($response);
  }
}
?>
