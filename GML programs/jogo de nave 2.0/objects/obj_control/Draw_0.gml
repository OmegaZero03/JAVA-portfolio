/// @description desenhando nivel

var mostrador_de_nivel = string(global.lvl);
var mostrador_de_xp = string(xp_atual);


//fonte
draw_set_font(fnt_sans);


//mostrando
draw_text(80, 10, "LVL : " + mostrador_de_nivel);
draw_text(75, 30, " Pontos : " + mostrador_de_xp);


//resetando fonte e cor
draw_set_font(-1);

