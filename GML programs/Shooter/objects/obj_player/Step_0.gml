/// @description Insert description here
// You can write your code in this editor

//Movimento
var cima = keyboard_check(ord("W"));
var baixo = keyboard_check(ord("S"));
var direita = keyboard_check(ord("D"));
var esquerda = keyboard_check(ord("A"));

if(!cima and !baixo and !direita and !esquerda){
vel = 0;
}else{
vel = 3;	
}
var dir = point_direction(0,0, (direita - esquerda), (baixo - cima));

direction = dir;
speed = vel;

// Atirando

var tiro_c = keyboard_check(vk_up);
var tiro_b = keyboard_check(vk_down);
var tiro_d = keyboard_check(vk_right);
var tiro_e = keyboard_check(vk_left);

if (current_time < nextShoot)
{
	return;
}

nextShoot = current_time + 500;



if(tiro_c){

	global.dire_tiro = degtorad(90);
	instance_create_layer(x, y - 32, "Instances", obj_tiro);
	return;
}
if(tiro_b){

	global.dire_tiro = degtorad(270);
	instance_create_layer(x, y + 32, "Instances", obj_tiro);
	return;
}
if(tiro_d){

	global.dire_tiro = degtorad(0);
	instance_create_layer(x + 32, y, "Instances", obj_tiro);	
	return;
}
if(tiro_e) {

	global.dire_tiro = degtorad(180);
	instance_create_layer(x - 32, y, "Instances", obj_tiro);
	return;
}

if(vida == 0){
	
	show_message("Game Over");
	game_end();

}