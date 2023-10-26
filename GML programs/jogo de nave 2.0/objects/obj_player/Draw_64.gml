/// @description desenhando vida

var v = 1;
repeat(qdt_escudo)
{
	draw_sprite_ext(spr_escudo, 0, room_width - (20*v),room_height -30 ,.3, .3, image_angle, c_white, .7);
	v++;
}