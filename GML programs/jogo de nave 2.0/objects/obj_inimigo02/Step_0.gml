/// @description alrme

//alarme de criação do tiro


if (y > 0 && na_tela == false)
{
alarm[0] = room_speed * random_range(.5, 2);
na_tela = true;
}

if (na_tela == true && movendo == false) //se estiver na tela e ainda não está se movendo 
{
	if (y > room_height / 3) //se passar de 1/4 da altura da room
	{
		if (x > room_width / 2) //se esta na direita
		{
			hspeed = -4; //move pra esquerda
			movendo = true;
		}
		else //caso na esquerda
		{
			hspeed = 4;	//se move pra direita
			movendo = true;
		}
			
	}
	
}

if (vida_inimigo2 <= 0) instance_destroy();


if (y > room_height + 100) instance_destroy();