/// @description alrme

//alarme de criação do tiro


if (y > 0 && na_tela == false)
{
alarm[0] = room_speed * random_range(.5, 2);
na_tela = true;
}

if (y > room_height + 100) instance_destroy();