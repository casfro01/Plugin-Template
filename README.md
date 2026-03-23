# Dokumentation
## Commands
**`/Kit [kit navn]`**  
Tager et kit  
*Permission:* `kit.[kitnavn] eller kit.* for alle)`

---

**`/kits`**  
Viser liste over dine tilgængelige kits   
*Permission:* `kit`


### Aliases
- k


## Admin Commands

**`/kitadmin opret [Kit navn] [Cooldown?]`**  
Opretter et kit (hvis ingen cooldown er angivet, så er der ingen)  
*Permission:* `kit.admin.opret`

---

**`/kitadmin fjern [Kit navn] [confirm]`**  
Fjerner et kit  
*Permission:* `kit.admin.fjern`

---

**`/kitadmin give [spiller] [kit navn]`**  
Giver en spiller kittet  
*Permission:* `kit.admin.give` – giver adgang til at give **alle** kits

---

**`/kitadmin help`**  
Viser alle kommandoer  
*Permission:* `kit.admin`

---

**`/kitadmin list`**  
Viser en liste over alle tilgængelige kits samt deres permission  
*Permission:* `kit.admin.list`

---

**`/kitadmin reload`**  
Reloader configs  
*Permission:* `kit.admin.reload`

---

**`/kitadmin cooldown [Kit navn] [Cooldown]`**  
Sætter cooldown på et kit  
*Permission:* `kit.admin.setcooldown`

---

**`/kitadmin permission [Kit navn] [permission]`**  
Sætter permission for et kit  
*Permission:* `kit.admin.setpermission`

---

**`/kitadmin sync`**  
Synkronisere kits med databasen (en løsning hvis cooldown driller)  
*Permission:* `kit.admin.sync`


### Aliases
- ka
- KitAdmin
- Kitadmin
- kadmin
