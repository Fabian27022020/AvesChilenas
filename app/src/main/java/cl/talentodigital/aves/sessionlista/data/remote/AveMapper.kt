package cl.talentodigital.aves.sessionlista.data.remote

import cl.talentodigital.aves.sessionlista.domain.model.Ave

class AveMapper {

    fun mapToEntity(aveModel: AveModel) : Ave {
        aveModel.apply {
            return Ave(uid,name,images, links , sort)
        }
    }
}