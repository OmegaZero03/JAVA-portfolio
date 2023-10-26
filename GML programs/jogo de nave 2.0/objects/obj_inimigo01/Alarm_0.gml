/// @description alarme de tiro

instance_create_layer(x, y, "inimigos", obj_tiro_inimigo01);

//reativando o alarme
alarm[0] = room_speed * random_range (1.5, 3);
