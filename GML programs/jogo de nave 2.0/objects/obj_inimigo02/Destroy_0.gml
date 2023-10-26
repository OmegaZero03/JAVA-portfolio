/// @description explosao ao sumir

instance_create_layer(x, y, "inimigos", obj_explosao);

//valor do xp dado

if(tomei_tiro)
{
	scr_treme(15, noone, "inimigos");
	obj_control.xp_atual += 3;
	global.inimigos_destruidos++;

	//chance de dropar o item
	var chance = random (100);

	if (chance > 95) instance_create_layer(x, y, "Instances", obj_powerup);
	
	var chance1 = random(100);
	
	if (chance1 > 92) instance_create_layer(x, y, "instances", obj_powerup_spd);
}
