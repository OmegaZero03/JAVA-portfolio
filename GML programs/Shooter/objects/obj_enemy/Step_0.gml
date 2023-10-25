/// @description Insert description here
// You can write your code in this editor

	
	
move_towards_point(obj_player.x, obj_player.y, 1);

if(vida == 0){
	
	global.num_mortos++;
	instance_destroy(self);

}



