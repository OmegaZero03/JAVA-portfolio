/// @description Insert description here
// You can write your code in this editor

if (xp_atual >= xp_proximo_nivel)
{
	global.lvl++;
	xp_proximo_nivel *= 2;
}

if ((global.lvl >= 5) && (boss == false))
{
	instance_create_layer(room_width / 2, -700, "inimigos", obj_boss);
	instance_destroy(obj_inimigo01);
	instance_destroy(obj_inimigo02);
	boss = true;
	audio_stop_all();
}

if(xp_atual > global.pontos)
{

	global.pontos = xp_atual;

}