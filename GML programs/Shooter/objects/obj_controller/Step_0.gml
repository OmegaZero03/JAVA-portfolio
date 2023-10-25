/// @description Insert description here
// You can write your code in this editor

ranx =  random_range(32, 1344);
rany = random_range(0, 704);

if(current_time < tempo) return;

if(instance_number(obj_enemy) >= 5) return;

instance_create_layer(ranx, rany, "Instances", obj_enemy);
tempo = current_time + 2000;

if(global.num_mortos >= 5){
	with(obj_enemy)instance_destroy();
}
