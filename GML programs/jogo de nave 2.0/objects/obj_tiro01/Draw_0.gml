/// @description efeitinhou

//me desenhando
draw_self();

//desenhnado por cima da minha sprite
gpu_set_blendmode(bm_add); //colocando uma imagem em cima da outra

//aqui ta como vai ficar a imagem por cima (pra dar um efeito massa)
draw_sprite_ext(sprite_index, image_index, x, y, image_xscale + 1, image_yscale + .2, image_angle, cor, .5)

gpu_set_blendmode(bm_normal);// voltando ao normal pra n ficar infidnito