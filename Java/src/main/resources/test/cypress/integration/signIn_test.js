/*
    Diese Testcases prüfen die Signin Seite
*/
describe('Signin Page', function() {
    
    /*
        Dieser Testcase ruft die Seite auf
    */
    it('Loginpage aufrufen', function() {
      cy.visit('http://localhost:8080/signin')    //URL richtig einfügen
    })

    /*
        Dieser Testcase prüft ob die Überschrift vorhanden ist
    */
    it('Loginpage Ueberschrift pruefen', function() {
        cy.visit('http://localhost:8080/')                   //URL richtig einfügen

        //prüfen ob die Überschirft vorhanden ist:
        cy.contains('Anmeldung')
      })

    /*
        Dieser Testcase prüft ob die Inputfelder vorhanden sind und schreibt in diese etwas hinein
    */
      it('Loginpage Inputfelder pruefen', function() {
        cy.visit('http://localhost:8080/')      //URL richtig einfügen

        //prüfen ob das Eingabefeld Username vorhanden ist:
        cy.get('.input-sm').type('sampleuser@domain.com').should('have.value', 'sampleuser@domain.com')

        //prüfen ob das Eingabefeld Password vorhanden ist:
        cy.get('.input-sm').type('1233').should('have.value', '1233')   //hier muss die Klasse input-sm noch geändert werden
      })

    /*
        Dieser Testcase prüft ob die Buttons vorhanden sind und klickt diese
    */
      it('Loginpage Buttons pruefen', function() {
        cy.visit('http://localhost:8080/')    //URL richtig einfügen

        //prüfen ob Anmelden Button vorhanden ist
        cy.get('.btn-primary').click()

        //prüfen ob Registrierungslink vorhanden ist
        cy.contains('Registrierung')
      })
  })
