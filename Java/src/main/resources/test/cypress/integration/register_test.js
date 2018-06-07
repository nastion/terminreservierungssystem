describe('Register Page', function() {
    it('Registerpage aufrufen', function() {
      cy.visit('http://localhost/')             //URL muss noch geändert werden
    })

    it('Registerpage Ueberschrift pruefen', function() {
        cy.visit('http://localhost/')                   //URL richtig einfügen

        //prüfen ob die Überschirft vorhanden ist:
        cy.contains('Registrierung')
      })

      it('Registerpage Inputfelder pruefen', function() {
        cy.visit('http://localhost/')                   //URL richtig einfügen

        //Usernamenfeld prüfen
        cy.get('.input-sm').type('sampleuser@domain.com').should('have.value', 'sampleuser@domain.com')

        //Passwortfeld prüfen
        cy.get('.input-sm').type('pw123').should('have.value', 'pw123')     //Klasse muss noch geändert werden
      })

      it('Registerpage Button pruefen', function() {
        cy.visit('http://localhost/')                   //URL richtig einfügen

        //Registerbutton prüfen
        cy.get('btn-primary').click()
      })
  })