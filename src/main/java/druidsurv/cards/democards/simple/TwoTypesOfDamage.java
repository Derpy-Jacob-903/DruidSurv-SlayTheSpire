package druidsurv.cards.democards.simple;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

@AutoAdd.Ignore
public class TwoTypesOfDamage extends AbstractEasyCard {
    public final static String ID = makeID(TwoTypesOfDamage.class.getSimpleName());
    // intellij stuff skill, self, uncommon, , , , , ,

    public TwoTypesOfDamage() {
        super(ID, 1, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY); // This card is a 1 cost Common Attack that targets an Enemy.
        baseDamage = 8;
        baseSecondDamage = 15;
        setPortraitTextures("druidsurvResources/images/cardui/512/frame_attack_hidden.png", "druidsurvResources/images/cardui/1024/frame_attack_hidden.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (p.hasPower(VulnerablePower.POWER_ID)) // If you have VulnerablePower (vulnerable),
            altDmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY); // Deal damage based on secondDamage.
        else
            dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT); // Otherwise deal normal damage.
    }

    @Override
    public void upp() {
        upgradeDamage(2);
        upgradeSecondDamage(5);
    }
}