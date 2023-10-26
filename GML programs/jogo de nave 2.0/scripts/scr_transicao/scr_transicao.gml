// Script assets have changed for v2.3.0 see
// https://help.yoyogames.com/hc/en-us/articles/360005277377 for more information
///@arg destino
///@arg layer
function scr_transicao(){

var d = argument0;
var l = argument1;

var trans = instance_create_layer(0, 0, string(l), obj_trasicao);
trans.destino = d;
}