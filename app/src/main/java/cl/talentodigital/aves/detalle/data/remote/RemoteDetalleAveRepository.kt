package cl.talentodigital.aves.detalle.data.remote


import cl.talentodigital.aves.detalle.domain.DetalleAveRepository
import cl.talentodigital.aves.detalle.domain.model.DetalleAve


class RemoteDetalleAveRepository  (
    private val detalleAveApi: DetalleAveApi,
    private val detalleAveMapper: DetalleAveMapper
): DetalleAveRepository {


    override suspend fun obtenerDetalle(uid : String): DetalleAve {
        return detalleAveMapper.mapToEntity(detalleAveApi.getDetalleAveApi(uid))

    }
}