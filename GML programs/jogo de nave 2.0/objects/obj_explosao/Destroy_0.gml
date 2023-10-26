/// @description indo pra próxima sala

if(instance_exists(obj_player))
{
	
if(paiboss)
{
	if(obj_player.lvltiro > 1 || obj_player.vel > 3)
	{
	scr_transicao(rm_final, "instances");
	}else
	{
		scr_transicao(rm_final_secreto, "instances");
	}
	
}

}
