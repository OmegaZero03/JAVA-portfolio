/// @description Insert description here
// You can write your code in this editor

var dt = delta_time / 1000000;

var nx = cos(shootDir);
var ny = -sin(shootDir);

var len = sqrt(sqr(nx) + sqr(ny)) / (shootSpeed * dt * 100);

nx = nx / len;
ny = ny / len;

x = x + nx;
y = y + ny;
