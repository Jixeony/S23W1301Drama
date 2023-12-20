package kr.ac.kumoh.s20210310.s23w1301drama

data class Drama(
    val drama_id: Int,
    val title: String,
    val genre: String,
    val release_year: Int,
    val description: String?
)