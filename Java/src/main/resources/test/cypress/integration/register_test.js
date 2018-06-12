/*
    Diese Testcases testen die Seite der User Registrierung
*/
describe('Register Page', function() {
    
    /*
        Dieser Testcase ruft die Seite auf
    */
    it('Registerpage aufrufen', function() {
      cy.visit('http://localhost:8080/')             //URL muss noch geändert werden
    })

    /*
        Dieser Testcase prüft ob die Überschrift vorhanden ist
    */
    it('Registerpage Ueberschrift pruefen', function() {
        cy.visit('http://localhost/')                   //URL richtig einfügen

        //prüfen ob die Überschirft vorhanden ist:
        cy.contains('Registrierung')
      })

    /*
        Dieser Testcase prüft ob die Inputfelder vorhanden sind und schreibt in diese etwas hinein
    */
      it('Registerpage Inputfelder pruefen', function() {
        cy.visit('http://localhost/')                   //URL richtig einfügen

        //Usernamenfeld prüfen
        cy.get('.input-sm').type('sampleuser@domain.com').should('have.value', 'sampleuser@domain.com')

        //Passwortfeld prüfen
        cy.get('.input-sm').type('pw123').should('have.value', 'pw123')     //Klasse muss noch geändert werden
      })

    /*
        Dieser Testcase prüft, ob der Button vorhanden ist und klickt diesen
    */
      it('Registerpage Button pruefen', function() {
        cy.visit('http://localhost/')                   //URL richtig einfügen

        //Registerbutton prüfen
        cy.get('btn-primary').click()
      })
  })
