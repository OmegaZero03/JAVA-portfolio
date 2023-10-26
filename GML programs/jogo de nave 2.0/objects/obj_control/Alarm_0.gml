/// @description criando inimigos

if(boss == false)
{
	randomize();
	var repete = random_range(1, 6) * global.lvl;

	repeat(repete)
	{
		//room_width = tamnha da tela - 800.
		var x_minEmax = random_range(32, room_width - 32);
		var y_minEmax = random_range(-32, -1024);
		var chance = random (10) * global.lvl;
	
		if(chance > 25)
		{
			var inimigo = instance_create_layer(x_minEmax, y_minEmax, "inimigos", obj_inimigo02);
			inimigo.speed = random_range(2, 5);
		}
		else
		{
		var inimigo = instance_create_layer(x_minEmax, y_minEmax, "inimigos", obj_inimigo01);
		inimigo.speed = random_range(2, 4);
		}
	}

	//reativando alrme
	alarm[0] = (random_range(2, 12) * room_speed);
}