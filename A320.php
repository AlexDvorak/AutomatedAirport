<?php
include_once("plane.php");
include_once("atc.php");
class A320 extends Plane{
  function __construct($lat,$long){
    $this->title = "AIRBUS_A320";
    $this->id = "N".(string)rand(0,9).(string)rand(0,9).(string)rand(0,9).(string)rand(0,9).(string)rand(0,9);
    $this->maxCapacity = 160;
    $this->maxFuel = 6400;
    $this->nmpg = 1.485;
    $this->range = $this->maxFuel/$this->nmpg;
    $this->wingspan = 117.3125;
    $this->length = 123.25;
    $this->currentFuel = 0;
    $this->currentPassengers = 0;
    $this->flightNumber = NULL;
    $this->latitude = $lat;
    $this->longitude = $long;
    $this->currentTaxiway = NULL;
    $this->currentGate = NUll;
    $this->speed = 10;
    $this->currentSpeed = 0;
  }
}
$plane = new A320(12,13);
$SFOGND = new GND;
$plane->request("taxirequest",$SFOGND);
print_r($SFOGND->queue);
$SFOGND->respond($plane->id);
print_r($SFOGND->responses);
?>
