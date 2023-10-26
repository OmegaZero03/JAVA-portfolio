/// @description colidindo e matado o inimigo

with(other) tomei_tiro = true;

//destruindo o tiro
instance_destroy();

//destruindo o inimigo
instance_destroy(other);

