const allVenues = [];
const allVenueTypes = [];
const allLocations = [];
const allAddresses = [];

$(document).ready(function() {
    resolveAuthorizationButtons();
    
    $.ajax({
        type: 'GET',
        url: 'api/venues',
        dataType: 'json',
        success: function(retrievedVenues) {
            for (let venue of retrievedVenues) {
                allVenues.push(venue);

                let newTableRow = $('<tr></tr>');
                
                let newTableHeader = $('<th></th>');
                newTableHeader.attr('scope', 'row');
                newTableHeader.text(venue['id']);
                newTableRow.append(newTableHeader);

                let newTableData = $('<td></td>');
                newTableData.addClass('nameTableData');
                newTableData.text(venue['name']);
                newTableRow.append(newTableData);

                newTableData = resolveVenueType(venue['typeId']);
                newTableRow.append(newTableData);

                newTableData = resolveStatus(venue['status']);
                newTableRow.append(newTableData);
                
                newTableData = resolveLocation(venue['locationId']);
                newTableRow.append(newTableData);
                
                newTableData = resolveLogo(venue['logoPath']);
                newTableRow.append(newTableData);

                newTableData = $('<td></td>');
                newTableData.addClass('averageGradeTableData');
                newTableData.text(venue['averageGrade']);
                newTableRow.append(newTableData);

                newTableData = resolveWorkingHours(venue['workingHours']);
                newTableRow.append(newTableData);

                $('#venuesTable > tbody').append(newTableRow);
            }
        },
        error: function(message) {
            alert(message.responseText);
        }
    });
});

function resolveAuthorizationButtons() {
    $('#registrationAsABuyerButton').click(function() {
        window.location.href = 'registration.html';
    });
    
    $.ajax({
        type: 'GET',
        url: 'api/authorization/logged-user',
        dataType: 'json',
        success: function() {
            $('#loginButton').hide();
            
            $('#logoutButton').show();
            $('#logoutButton').removeAttr('hidden');
            $('#logoutButton').click(function() {
                $.ajax({
                    type: 'POST',
                    url: 'api/authorization/logout',
                    data: '',
                    success: function() {
                        alert('Korisnik je uspešno odjavljen!');
                        
                        window.location.href = 'index.html';
                    },
                    error: function(message) {
                        alert(message.responseText);
                    }
                });
            });
        },
        error: function() {
            $('#loginButton').show();
            $('#loginButton').removeAttr('hidden');
            $('#loginButton').click(function() {
                window.location.href = 'login.html';
            });
            
            $('#logoutButton').hide();
        }
    });
}

function resolveVenueType(typeId) {
    let venueTypeTableData = $('<td></td>');
    venueTypeTableData.addClass('typeTableData');

    for (let vType of allVenueTypes) {
        if (vType['id'] == typeId) {
            venueTypeTableData.text(vType['name']);
            
            return venueTypeTableData;
        }
    }
    
    $.ajax({
        async: false,
        type: 'GET',
        url: 'api/venue-types/' + typeId,
        dataType: 'json',
        success: function(retrievedVenueType) {
            allVenueTypes.push(retrievedVenueType);
            venueTypeTableData.text(retrievedVenueType['name']);
        },
        error: function(message) {
            alert(message.responseText);
        }
    });

    return venueTypeTableData;
}

function resolveStatus(status) {
    let statusTableData = $('<td></td>');
    statusTableData.addClass('statusTableData');

    if (status == 'WORKING') {
        statusTableData.text('Radi');
    } else if (status == 'NOT_WORKING') {
        statusTableData.text('Ne radi');
    }
    
    return statusTableData;
}

function resolveLocation(locationId) {
    let locationTableData = $('<td></td>');
    locationTableData.addClass('locationTableData');

    for (let l of allLocations) {
        if (l['id'] == locationId) {
            locationTableData.append(createLocationCard(l));

            return locationTableData;
        }
    }

    $.ajax({
        async: false,
        type: 'GET',
        url: 'api/locations/' + locationId,
        dataType: 'json',
        success: function(retrievedLocation) {
            allLocations.push(retrievedLocation);
            locationTableData.append(createLocationCard(retrievedLocation));
        },
        error: function(message) {
            alert(message.responseText);
        }
    });

    return locationTableData;
}

function createLocationCard(location) {
    let locationCard = $('<div></div>');
    locationCard.addClass('card text-center text-white bg-dark border-light');

    for (let a of allAddresses) {
        if (a['id'] == location['addressId']) {
            locationCard.append(fillOutLocationCardBody(a, location));

            return locationCard;
        }
    }
    
    $.ajax({
        async: false,
        type: 'GET',
        url: 'api/addresses/' + location['addressId'],
        dataType: 'json',
        success: function(retrievedAddress) {
            allAddresses.push(retrievedAddress);
            locationCard.append(fillOutLocationCardBody(retrievedAddress, location));
        },
        error: function(message) {
            alert(message.responseText);
        }
    });
    
    return locationCard;
}

function fillOutLocationCardBody(address, location) {
    let locationCardBody = $('<div></div>');
    locationCardBody.addClass('card-body');
    
    let locationCardTitle = $('<h5></h5>');
    locationCardTitle.addClass('card-title');
    locationCardTitle.text(address['street'] + ' ' + address['number']);
    
    let locationCardSubtitle = $('<h6></h6>');
    locationCardSubtitle.addClass('card-subtitle mb-2');
    locationCardSubtitle.text(address['populatedPlace'] + ' ' + address['postalCode']);
    
    let locationCardText = $('<p></p>');
    locationCardText.addClass('card-text');
    locationCardText.text(location['latitude'] + ' ' + location['longitude']);
    
    locationCardBody.append(locationCardTitle);
    locationCardBody.append(locationCardSubtitle);
    locationCardBody.append(locationCardText);
    
    return locationCardBody;
}

function resolveLogo(logoPath) {
    let logoTableData = $('<td></td>');
    logoTableData.addClass('logoTableData');

    let logoElement = $('<img>');
    logoElement.addClass('img-fluid rounded mx-auto d-block');
    logoElement.attr('src', logoPath);
    logoElement.attr('alt', 'logo');

    logoTableData.append(logoElement);
    
    return logoTableData;
}

function resolveWorkingHours(workingHours) {
    let workingHoursTableData = $('<td></td>');
    workingHoursTableData.addClass('workingHoursTableData');
    workingHoursTableData.text(workingHours['openingHours'] + ' - ' + workingHours['closingHours']);
    
    return workingHoursTableData;
}
