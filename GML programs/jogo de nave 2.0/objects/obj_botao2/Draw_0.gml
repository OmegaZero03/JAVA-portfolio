/// @description desenhnado o jogar

draw_self();

draw_set_color(c_black);
draw_set_font(fnt_sans);


draw_set_valign(fa_middle); //vertical
draw_set_halign(fa_center); //horizontal

draw_text(x, y, texto);

draw_set_font(-1);
draw_set_color(-1);

//mudando a cor
image_blend = c_aqua;