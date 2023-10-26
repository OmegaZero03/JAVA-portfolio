/// @description começando a mudar o nova_room

if (sumindo)
{
	alpha -= .1;
}else
{
	alpha += .1;
}

if (alpha >= 1)
{
	sumindo = true;
	room_goto(destino);
}

if (alpha <= 0 && nova_room)
{
	
	instance_destroy();

}
