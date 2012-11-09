package com.enterprisewebbook.ch8.sse.domain;

/**
* TODO
*
* @author Viktor Gamov (http://log.javaheadbrain.com)
* @since 11/5/12
*/
public class Donor {
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String fullName;
    private String email;
    private String address;
    private String city;
    private String zip;
    private String state;
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Donor donor = (Donor) o;

        if (address != null ? !address.equals(donor.address) : donor.address != null) return false;
        if (city != null ? !city.equals(donor.city) : donor.city != null) return false;
        if (!country.equals(donor.country)) return false;
        if (!email.equals(donor.email)) return false;
        if (!fullName.equals(donor.fullName)) return false;
        if (state != null ? !state.equals(donor.state) : donor.state != null) return false;
        if (zip != null ? !zip.equals(donor.zip) : donor.zip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fullName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + country.hashCode();
        return result;
    }
}
