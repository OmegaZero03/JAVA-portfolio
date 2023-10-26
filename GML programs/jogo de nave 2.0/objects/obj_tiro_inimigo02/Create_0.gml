/// @description tiro do inimigo02


//direção do player
if (instance_exists(obj_player))
{
direction = point_direction(x, y, obj_player.x, obj_player.y);
//x1 == x do tiro
//y1 == y do tiro
//x2 == x do player
//y2 == y do player
}
else
{
	direction = 270;	
}

// Velocidade do tiro
speed = 4;

//direção do tiro
image_angle = 180;

audio_play_sound(snd_tiro_inimigo, 5, false);