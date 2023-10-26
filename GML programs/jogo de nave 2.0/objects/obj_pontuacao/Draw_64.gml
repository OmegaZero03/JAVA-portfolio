/// @description Insert description here
// You can write your code in this editor

if (room == rm_pontos)
{
	draw_set_font(fnt_escrita);
	draw_set_halign(fa_center);
	draw_text(room_width / 2, 200, "Pontos:");
	
	draw_set_font(fnt_sans)
	draw_text(room_width / 2, room_height / 2, global.pontos);
	
	draw_text(room_width / 2, (room_height / 2) + 50, "inimigos destruidos: " + string(global.inimigos_destruidos));
	
	draw_set_halign(fa_left);
	draw_set_font(-1);
}
