/// @description queda do power up
randomize();
speed = random_range(.2, 1);
direction = random(360);  

v = random_range(.01, .1);

image_xscale = .5;
image_yscale = .5;

aumentando = true;
diminuindo = false;



//sistema de cor

cor = c_aqua;	
	
	
alarm[0] = room_speed * 10;