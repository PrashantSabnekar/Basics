package catss


case class Song(name: String, durationInSeconds: Int)
case class Album(name: String, songs: List[Song])
case class Artist(name: String, albums: List[Album])

class CatsDemo {

  var artists =  List[Artist]()
  var songs: List[Song]  = List()

  def getSongs(id: Int): List[Song] = {
    val s1 = Song("Song One", 10)
    val s2 = Song("Song Two", 15)
    val s3 = Song("Song Three", 10)
    val s4 = Song("Song Four", 15)
    val s5 = Song("Song Five", 10)
    val s6 = Song("Song Six", 15)
    val s7 = Song("Song Seven", 10)
    val s8 = Song("Song Eight", 15)
    val s9 = Song("Song Nine", 10)
    val s10 = Song("Song Tex", 15)
    val s11 = Song("Song Eleven", 10)
    val s12 = Song("Song Twelve", 15)

    id match {
      case 1 => List(s1,s2,s3,s4)
      case 2 => List(s5,s6,s7,s8)
      case 3 => List(s9,s10,s11,s12)
      case _ => List()
    }

  }

  def getAlbums(id: Int): List[Album] = {
    val a1 = Album("Album One", getSongs(1))
    val a2 = Album("Album Two", getSongs(2))
    val a3 = Album("Album Three", getSongs(3))

    id match {
      case 1 => List(a1, a2)
      case 2 => List(a3)
    }
  }

  def getArtist(): List[Artist] = {
    val a1 = Artist("Lata", getAlbums(1))
    val a2 = Artist("Usha", getAlbums(2))
    List(a1, a2)
  }

  def initialize(): Unit = {
    artists = getArtist()
  }

  def findSong(
                artists: List[Artist],
                artistName: String,
                albumName: String,
                songName: String): Option[Song] = for {
    artist <- artists.find { _.name == (artistName) }
    album  <- artist.albums find { _.name == (albumName) }
    song   <- album.songs   find { _.name == (songName) }
  } yield song

  def demo() = {
    initialize()

    val song = findSong(artists, "Lata", "Album One", "Song One")
    song match {
      case Some(s) => println(s.name)
      case None => println("NA")
    }
  }
}


object Demo extends App {
  val ot = new CatsDemo
  ot.demo()
}