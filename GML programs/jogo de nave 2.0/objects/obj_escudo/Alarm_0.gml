/// @description diminuindo o escudo

if(image_index <= 0)
{
	instance_destroy();	
	audio_play_sound(snd_destruindo_escudo, 5, false);
}
else alarm[0] = room_speed * 1;

image_index--;