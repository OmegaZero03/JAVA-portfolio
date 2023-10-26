// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
///@arg força
///@arg som
///@arg layer
function scr_treme(){

var f = argument0;
var s = argument1;
var l = argument2;

var treme = instance_create_layer(0, 0, string(l), obj_treme);
treme.f = f;
treme.s = s;



}