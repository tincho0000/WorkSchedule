use timetracker;

CREATE TABLE estimacion_tarea (
                                  id_estimacion bigint NOT NULL AUTO_INCREMENT,
                                  nombre varchar(255),
                                  requerimiento_id bigint,
                                  fecha_desde date,
                                  fecha_hasta date,
                                  puntos_configuracion bigint,
                                  puntos_funcion bigint,
                                  hs_no_medibles double,
                                  total_hs double,
                                  total_hs_reales double,
                                  fecha_entrega_testing_p date,
                                  fecha_entrega_testing_r date,
                                  PRIMARY KEY (id_estimacion)
);