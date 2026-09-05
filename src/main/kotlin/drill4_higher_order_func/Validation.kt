package drill4_higher_order_func

data class Candidate(var name: String?, var age: Int?, var email: String?)

sealed class ValidateResult {
    object Valid : ValidateResult()
    data class NotValid(val reason: String) : ValidateResult()
}

fun validateCandidate(candidate: Candidate, rule: (Candidate) -> ValidateResult): ValidateResult {
    return rule(candidate)
}

fun printResult(hasil: ValidateResult) {
    when (hasil) {
        is ValidateResult.Valid -> println("✅ Valid")
        is ValidateResult.NotValid -> println("❌ Tidak valid: ${hasil.reason}")
    }
}

fun main() {
    val listCandidate = listOf(
        Candidate("Adi", 18, "adi@gmail.com"),
        Candidate("Ebi", 14, "ebi@gmail.com"),
        Candidate("Udin", 19, "udingmail.com"),
        Candidate("Siska", 20, null),
        Candidate(null, null, "edwin@gmail.com")
    )

    val cekName: (Candidate) -> ValidateResult = { c ->
        if (c.name?.isBlank() == true || c.name?.isEmpty() == true ){
            ValidateResult.NotValid("Nama tidak boleh kosong")
        }  else {
            ValidateResult.Valid
        }
    }

    val cekAge: (Candidate) -> ValidateResult = { c ->
        val umur = c.age
        if (umur == null){
            ValidateResult.NotValid("Umur belum diisi")
        } else if (umur < 17){
            ValidateResult.NotValid("Harus berusia minimal 17 tahun")
        } else{
            ValidateResult.Valid
        }
    }

    val cekEmail: (Candidate) -> ValidateResult = { c ->
        val surel = c.email
        if (surel == null){
            ValidateResult.NotValid("Email belum diisi")
        } else if (!surel.contains("@")) {
            ValidateResult.NotValid("Format email tidak valid")
        } else {
            ValidateResult.Valid
        }
    }

    for (candidate in listCandidate) {
        println("Mengecek: ${candidate.name}")
        printResult(validateCandidate(candidate, cekName))
        printResult(validateCandidate(candidate, cekAge))
        printResult(validateCandidate(candidate, cekEmail))

        println()
    }
}