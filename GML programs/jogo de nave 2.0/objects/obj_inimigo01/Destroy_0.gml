/// @description explosao ao sumir

instance_create_layer(x, y, "inimigos", obj_explosao);

//xp próximo nivel

if (tomei_tiro)
{
	scr_treme(10, noone, "inimigos");
	obj_control.xp_atual += 2;
	global.inimigos_destruidos ++;
	var chance = random (100);
	if (chance > 98) instance_create_layer(x, y, "Instances", obj_powerup);
	var chance1 = random(100);
	if (chance1 > 95) instance_create_layer(x, y, "instances", obj_powerup_spd);
}

