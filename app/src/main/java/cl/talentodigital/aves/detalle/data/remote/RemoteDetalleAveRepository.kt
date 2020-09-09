package cl.talentodigital.aves.detalle.data.remote


import cl.talentodigital.aves.detalle.domain.DetalleAveRepository
import cl.talentodigital.aves.detalle.domain.model.DetalleAve


class RemoteDetalleAveRepository  (
    private val detalleAveApi: DetalleAveApi,
    private val detalleAveMapper: DetalleAveMapper
): DetalleAveRepository {


    override suspend fun obtenerDetalle(): DetalleAve {
        val detalleAve = detalleAveApi.getDetalleAveApi()
        return DetalleAve(detalleAve.uid,
            detalleAve.name,
            detalleAve.map,
            detalleAve.iucn,
            detalleAve.species)
    }
}