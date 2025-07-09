package druidsurv.cards.nemesis;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.red.Bash;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.AbstractPowerCostCard;
import druidsurv.powers.mox.GreenMox;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class Bash_Mage extends AbstractEasyCard {
    public final static String ID = makeID("NemBash");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Bash_Mage() {
        super(ID, 2, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY, CharacterFile.Enums.NEMDRUID_COLOR, "MonkeyApprentice_CardArt");
        baseDamage = 8;
        baseMagicNumber = 2;
        magicNumber = baseMagicNumber;
        setOrbTexture("druidsurvResources/images/512/g_mox.png", "druidsurvResources/images/1024/g_mox.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        atb(new ApplyPowerAction(m, p, new VulnerablePower(m, magicNumber, false), magicNumber));
    }

    @Override
    public void upp() {
        upgradeDamage(2);
        upgradeMagicNumber(1);
    }
}