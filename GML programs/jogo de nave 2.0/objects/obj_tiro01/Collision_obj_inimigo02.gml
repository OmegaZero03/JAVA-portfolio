/// @description destruir inimigo feio

with(other) tomei_tiro = true;

//destruindo o tiro
instance_destroy();

//dando dano no inimigo
with(other)
{
	vida_inimigo2 --;	
}


