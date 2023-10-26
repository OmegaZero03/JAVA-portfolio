/// @description efeitinhou top

draw_self();

gpu_set_blendmode(bm_add);

draw_sprite_ext(sprite_index, image_index, x, y, image_xscale + .5, image_yscale + .2, image_angle, cor, .5);

gpu_set_blendmode(bm_normal);
