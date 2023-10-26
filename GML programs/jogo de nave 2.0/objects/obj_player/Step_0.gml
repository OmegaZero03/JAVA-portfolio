/// @description movimentanção

//variáveis de locomoção

var esq = keyboard_check(vk_left);
var dir = keyboard_check(vk_right);
var cima = keyboard_check(vk_up);
var baixo = keyboard_check(vk_down);
var tiro = keyboard_check_pressed(ord("Z"));
var escudo = keyboard_check_pressed(ord("X"));

//limitando o player

x = clamp(x, 32, room_width - 32);
y = clamp(y, 32, room_height - 32); 

//-------------Movimento vertical-------------

// velh = Velocidade horizontal
var velh = (dir - esq) * vel; // (0-1) * 3 = -3

//fazendo aumentar pogger
x += velh;


//-------------Moviemnto horizontal-------------

//velv = Velocidade Vertical
var velv = (baixo - cima) * vel; //(1-0) * 3 = 3

//fazendo funcionar
y += velv;

//fazendo escudo aparecer
if(escudo && qdt_escudo > 0)
{
	instance_create_layer(x, y, "instances", obj_escudo);
	qdt_escudo--;
	audio_play_sound(snd_criando_escudo, 5, false);
}


//fazendo tiro sair 
if(lvltiro == 1)
{
	if (tiro)
	{
	instance_create_layer(x, y, "Instances", obj_tiro01);
	}
}else if(lvltiro == 2)
{
	if(tiro)
	{
	var t = instance_create_layer(x + 15, y, "Instances", obj_tiro02);
	t.hspeed = 4;
	
	var t = instance_create_layer(x - 15, y, "Instances", obj_tiro02);
	t.hspeed = -4;
	}
}else if(lvltiro == 3)
{
	if(tiro)
	{
		instance_create_layer(x, y, "Instances", obj_tiro01);
		var t = instance_create_layer(x + 15, y, "Instances", obj_tiro02);
			t.hspeed = 4;
	
		var t = instance_create_layer(x - 15, y, "Instances", obj_tiro02);
			t.hspeed = -4;
	}
	
}else if(lvltiro == 4)
{
	if(tiro)
	{
		var val = 20;
		repeat(3)
		{
			var t = instance_create_layer(x, y, "Instances", obj_tiro01);
			t.direction = 90 + val;
			t.image_angle = val;
			val -= 20;
		}	
	}
}else if(lvltiro == 5)
{
	if(tiro)
	{
		var val = 20;
		var t = instance_create_layer(x + 15, y, "instances", obj_tiro02);
			t.hspeed = 4;
		var t = instance_create_layer(x - 15, y, "instances", obj_tiro02);
			t.hspeed = -4;
			
				repeat(3)
				{
					var t = instance_create_layer(x ,y, "instances", obj_tiro01);
						t.direction = 90 + val;
						t.image_angle = val
						val -= 20;
				}
		
	}
}

if (tiro) audio_play_sound(snd_tiro_player, 10, false);

//-------------Sendo destruído-------------

if (vida <= 0) instance_destroy();
