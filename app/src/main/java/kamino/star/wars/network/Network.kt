package kamino.star.wars.network

class Network {

    companion object {
        val starWarsApi: StarWarsInterface =
            StarWarsClient().retrofit.create(StarWarsInterface::class.java)
    }
}
