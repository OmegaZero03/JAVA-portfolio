/// @description escudo seguindo player

if(instance_exists(obj_player))
{
x = obj_player.x
y = obj_player.y
}

//fazendo escudo desaparecer bonito

if(image_index == 0)
{
	image_alpha -= .03;	
}