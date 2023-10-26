/// @description fazendo o zig-zag

//herdando os eventos do outro tiro
event_inherited();

// clamp - ele n deixa ultrapassar o limite pré-estabelecido
if (x != clamp(x, xstart - 30, xstart + 30))
{
	hspeed *= -1;
}