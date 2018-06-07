describe('Signin Page', function() {
    it('Loginpage aufrufen', function() {
      cy.visit('http://localhost/')    //URL richtig einfügen
    })

    it('Loginpage Ueberschrift pruefen', function() {
        cy.visit('http://localhost/')                   //URL richtig einfügen

        //prüfen ob die Überschirft vorhanden ist:
        cy.contains('Anmeldung')
      })

      it('Loginpage Inputfelder pruefen', function() {
        cy.visit('http://localhost/')      //URL richtig einfügen

        //prüfen ob das Eingabefeld Username vorhanden ist:
        cy.get('.input-sm').type('sampleuser@domain.com').should('have.value', 'sampleuser@domain.com')

        //prüfen ob das Eingabefeld Password vorhanden ist:
        cy.get('.input-sm').type('1233').should('have.value', '1233')   //hier muss die Klasse input-sm noch geändert werden
      })

      it('Loginpage Buttons pruefen', function() {
        cy.visit('http://localhost/')    //URL richtig einfügen

        //prüfen ob Anmelden Button vorhanden ist
        cy.get('.btn-primary').click()

        //prüfen ob Registrierungslink vorhanden ist
        cy.contains('Registrierung')
      })
  })