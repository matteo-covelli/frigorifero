document.querySelector("body").addEventListener("click", showModal);

function showModal(e) {
  if (e.target.closest(".btn-aggiorna")) {
    var carta = e.target.closest(".carta");
    if (e.target.closest(".btn-aggiorna")) {
      var myModal = new bootstrap.Modal(
        document.querySelector("#exampleModal"),
        {}
      );

      document.querySelector(".id-postit").value = carta
        .querySelector(".n-postit")
        .textContent.trim();

      document.querySelector(".titolo-postit").value = carta
        .querySelector(".titolo")
        .textContent.trim();

      document.querySelector(".descrizione-postit").value = carta
        .querySelector(".body-postit")
        .textContent.trim();

      myModal.show();
    }
  }

  document.querySelector(".btn-add").addEventListener("click", clear);

  function clear(e) {
    document.querySelector(".id-postit").value = "";
    document.querySelector(".titolo-postit").value = "";
    document.querySelector(".descrizione-postit").value = "";
  }
}
