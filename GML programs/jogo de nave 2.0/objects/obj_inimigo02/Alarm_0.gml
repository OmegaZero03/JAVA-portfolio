/// @description alarme de tiro

if (instance_exists(obj_player))
{
	if (y + 64 < obj_player.y)
	{
	instance_create_layer(x, y, "inimigos", obj_tiro_inimigo02);
	}
}
//reativando o alarme
alarm[0] = room_speed * random_range (2, 4);
