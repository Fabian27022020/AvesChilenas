package cl.talentodigital.aves.detalle.domain

import cl.talentodigital.aves.detalle.domain.model.DetalleAve


interface DetalleAveRepository {
    suspend fun obtenerDetalle(uid : String): DetalleAve
}