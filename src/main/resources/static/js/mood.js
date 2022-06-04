async function openMood(evt, moodName) {
  var i, tabLinks;

  tabLinks = document.getElementsByClassName("tablink");
  for (i = 0; i < tabLinks.length; i++) {
      tabLinks[i].classList.remove('w3-red');
  }

  let grid = document.getElementById("grid");
  grid.style.display = "none";
  await renderPlaylist(grid, moodName);
  grid.style.display = "grid";

  evt.srcElement.className += " w3-red";
}

async function getPlaylists(moodName) {
    let url = encodeURIComponent(document.referrer) + 'mood/' + moodName;
    try {
        let res = await fetch(url);
        return res.json();
    } catch (error) {
        console.log(error);
    }
}

async function renderPlaylist(element, moodName) {
    while (element.firstChild) {
        element.removeChild(element.firstChild);
    }

    let playlists = await getPlaylists(moodName);
    playlists.forEach(playlist => {
        let cell = document.createElement("div");
        cell.classList.add("box", "w3-light-grey");
        cell.innerHTML = `<a href="${playlist.url}">${playlist.name}</a>`;
        element.appendChild(cell);
    });
}
